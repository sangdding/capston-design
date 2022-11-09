package chat_server.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultDto<D> {

    private final String resultCode;
    private final String message;
    private final D data;

    public static <D> ResultDto<D> ofSuccess() {
        return new ResultDto<>("success", null, null);
    }

    public static <D> ResultDto<D> ofSuccess(String message, D data) {
        return new ResultDto<>("success", message, data);
    }

    public static <D> ResultDto<D> ofFail(String message) {
        return new ResultDto<>("fail", message, null);
    }
}
