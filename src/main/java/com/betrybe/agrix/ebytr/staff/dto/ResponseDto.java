package com.betrybe.agrix.ebytr.staff.dto;

/**
 * Response.
 */
public record ResponseDto<T>(String message, T data) {}
