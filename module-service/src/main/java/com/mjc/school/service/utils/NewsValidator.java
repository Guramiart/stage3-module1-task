package com.mjc.school.service.utils;

import com.mjc.school.service.constants.ServiceConstants;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ArgumentValidException;
import com.mjc.school.service.exception.ErrorCode;
import com.mjc.school.service.exception.NotFoundException;

public class NewsValidator {

    private static NewsValidator instance;

    private NewsValidator() {}

    public static NewsValidator getInstance() {
        if(instance == null) {
            instance = new NewsValidator();
        }
        return instance;
    }

    public void validateDTO(NewsDTO newsDTO) throws ArgumentValidException, NotFoundException {
        this.validateString(newsDTO.getTitle(),
                ServiceConstants.TITLE_PARAM, ServiceConstants.MIN_TITLE_LENGTH, ServiceConstants.MAX_TITLE_LENGTH);
        this.validateString(newsDTO.getContent(),
                ServiceConstants.CONTENT_PARAM, ServiceConstants.MIN_CONTENT_LENGTH, ServiceConstants.MAX_CONTENT_LENGTH);
        this.validateAuthorId(newsDTO.getAuthorId());
    }

    public void validateNewsId(Long id) throws ArgumentValidException {
        this.validateNumber(id, ServiceConstants.NEWS_PARAM);
    }

    private void validateAuthorId(Long id) throws ArgumentValidException, NotFoundException {
        this.validateNumber(id, ServiceConstants.AUTHOR_PARAM);
        if(id > ServiceConstants.MAX_AUTHOR_ID) {
            throw new NotFoundException(String.format(
                    ErrorCode.NOT_EXIST.getErrorMessage(), ServiceConstants.AUTHOR_PARAM, id));
        }
    }

    private void validateNumber(Long num, String param) throws ArgumentValidException {
        if(num == null || num < 1) {
            throw new ArgumentValidException(String.format(
                    ErrorCode.NON_POSITIVE.getErrorMessage(), param, param, num));
        }
    }

    private void validateString(String content, String param, int min, int max) throws ArgumentValidException {
        if(content == null) {
            throw new ArgumentValidException(String.format(
                    ErrorCode.NULL_CONTENT.getErrorMessage(), param));
        } else if(content.length() < min || content.length() > max) {
            throw new ArgumentValidException(String.format(
                    ErrorCode.WRONG_LENGTH.getErrorMessage(), param, min, max, param, content));
        }
    }
}
