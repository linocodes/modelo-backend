package br.gov.mg.meioambiente.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import br.gov.mg.meioambiente.exception.NotFoundException;


/**
 * This class is meant to be extended by all REST resource "controllers".
 * It contains exception mapping and other common REST API functionality
 */
//@ControllerAdvice?
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected ApplicationEventPublisher eventPublisher;

    protected static final int  DEFAULT_PAGE_SIZE = 20;
    protected static final int DEFAULT_PAGE_NUM = 0;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new NotFoundException("resource not found");
        }
        return resource;
    }

}