package gxw.demo.rest;

import java.io.IOException;

import ocean.core.web.Attachment;
import ocean.data.bean.gridfs.GridFsTools;
import ocean.ext.mvc.file.AttachmentHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "FileTestController", description = "关于文件上传的相关操作")
@RestController
public class FileController {

    @Autowired
    GridFsTools fileTools;

    /**
     * 
     * 上传图片 .
     * 
     * @throws Exception
     * 
     */
    @ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "{code:1001003,message:'图片上传异常'}"),
            @ApiResponse(code = 400, message = "{code : 1002001, message:'未登录'}") })
    @ApiOperation(value = "上传用户头像", notes = "上传用户头像")
    @RequestMapping(value = "/pictures", method = RequestMethod.POST)
    public String uploadUserPicture(@ApiParam(name = "file", value = "头像文件") @RequestParam("file") MultipartFile file,
            @RequestParam("size_x") int[] size_x, @RequestParam("size_y") int[] size_y) throws Exception {
        try {

            if (size_x == null && size_y == null) {
                return uploadPicWithoutCompress(file);
            }

            if (size_x == null || size_y == null || size_x.length != size_y.length) {
                throw new Exception("error");
            }

            return uploadPicWithCompress(file, size_x, size_y);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     * 
     * 调用文件上传并压缩接口 .
     * 
     * @param file
     * @throws IOException
     */
    private String uploadPicWithoutCompress(MultipartFile file) throws IOException {
        Attachment attachment = AttachmentHelper.getInstance(file);
        return fileTools.save(attachment);
    }

    /**
     * 
     * 调用文件上传并压缩接口 .
     * 
     * @param file
     * @param size_x
     * @param size_y
     * @return String 文件名
     * @throws IOException
     */
    private String uploadPicWithCompress(MultipartFile file, int[] size_x, int[] size_y) throws IOException {
        Attachment attachment = AttachmentHelper.getInstance(file);
        return fileTools.saveWithCompress(attachment, size_x, size_y);
    }

}
