package authorization.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultDto {

    private final String resultCode;
    private final String message;

    public static ResultDto ofSuccess() {
        return new ResultDto("success", null);
    }

    public static ResultDto ofFail(String message) {
        return new ResultDto("fail", message);
    }
}
