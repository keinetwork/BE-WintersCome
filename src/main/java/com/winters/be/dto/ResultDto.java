package com.winters.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ResultDto<D> {
    @Schema(description = "결과코드", example = "SUCCESS", required = true)    
    private final String code;
    @Schema(description = "메시지", example = "완벽하게 처리되었습니다", required = true)
    private final String message;
    private final D data;

    public static <D> ResultDto<D> ofSuccess(String message, D data) {
        return new ResultDto<>("SUCCESS", message, data);
    }

    public static <D> ResultDto<D> ofFail(String message) {
        return new ResultDto<>("FAIL", message, null);
    }
}
