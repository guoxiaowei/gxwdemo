package gxw.demo.exception;

import ocean.core.exception.ExceptionInfo;
import ocean.core.exception.ExceptionInfoGetter;

import org.springframework.core.NestedRuntimeException;

public class DemoException extends NestedRuntimeException implements ExceptionInfoGetter {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String content;

    public DemoException(String content) {
        super(content);

        this.content = content;
    }

    public DemoException(String content, Throwable throwable) {
        super(content, throwable);

        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public ExceptionInfo getInfo() {
        ExceptionInfo exceptionInfo = new ExceptionInfo(this.code, this.content);
        return exceptionInfo;
    }
}

