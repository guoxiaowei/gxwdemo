package gxw.demo.rest;

import java.util.ArrayList;
import java.util.List;

import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class PageSortController {

	@Autowired
	private UserBiz biz;
	
	/**
	 * 
	 * @param pageable
	 ?page=0&size=5&sort=name,asc&sort=id,desc
	 * @return
		{
		    "content": [
		        {
		            "id": 1,
		            "name": "z",
		            "age": 0
		        }
		    ],
		    "size": 5,
		    "number": 0,
		    "lastPage": true,
		    "totalPages": 1,
		    "firstPage": true,
		    "sort": [
		        {
		            "direction": "ASC",
		            "property": "name",
		            "ignoreCase": false,
		            "ascending": true
		        },
		        {
		            "direction": "DESC",
		            "property": "id",
		            "ignoreCase": false,
		            "ascending": false
		        }
		    ],
		    "totalElements": 1,
		    "numberOfElements": 1
		}
	 */
    @RequestMapping(value = "/getUserPage", method = RequestMethod.GET)
    public Page<User> getUserPage(@PageableDefault(page=0,size=10) Pageable pageable) {
    	List<User> content = new ArrayList<>();
    	User user = new User(1, "z");
    	content.add(user);
		Page<User> userPage = new PageImpl<User>(content, pageable, 1);
    	
    	return userPage;
    }
    
    @RequestMapping(value = "/getUserPage2", method = RequestMethod.GET)
    public Page<User> getUserPage2(@PageableDefault(page=0,size=10) Pageable pageable) {
    	return biz.findUser(pageable);
    }
    
    /**
     * 
     * @param sort
     ?sort=name,asc&sort=id,desc
     * @return
     */
    @RequestMapping(value = "/getSortUser", method = RequestMethod.GET)
    public List<User> getSortUser(@SortDefault(sort="name") Sort sort) {
      return null;
    }
}
