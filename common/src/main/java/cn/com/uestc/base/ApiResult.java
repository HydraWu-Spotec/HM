package cn.com.uestc.base;

import cn.com.uestc.constant.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResult<T> {

    private Integer code;

    private String msg;

    private T data;

    /**
     * 成功返回:无入参和出参
     * @return
     */
    public static ApiResult<Void> ok(Runnable business) {
        business.run();
        return ApiResult.<Void>builder()
                .code(ResponseCode.SUCCESS)
                .build();
    }

    /**
     * 成功返回:有入参无出参
     * @param paramSupplier 入参处理
     * @param business 执行业务逻辑
     * @return
     * @param <D> 接口入参处理后的返回值泛型
     */
    public static <D> ApiResult<Void> okParam(Supplier<D> paramSupplier, Consumer<D> business) {
        business.accept(paramSupplier.get());
        return ApiResult.<Void>builder()
                .code(ResponseCode.SUCCESS)
                .build();
    }

    /**
     * 成功返回:无入参有出餐
     * @param business 执行业务逻辑
     * @param resultDeal 出参处理
     * @return
     * @param <B> 业务处理后返回值泛型
     * @param <T> 接口出参泛型
     */
    public static <B, T> ApiResult<T> okResult(Supplier<B> business, Function<B, T> resultDeal) {
        return ApiResult.<T>builder()
                .code(ResponseCode.SUCCESS)
                .data(resultDeal.apply(business.get()))
                .build();
    }

    /**
     * 成功返回:有入参和出餐
     * @param paramSupplier 入参处理
     * @param business 执行业务逻辑
     * @param resultDeal 出参处理
     * @return
     * @param <D> 接口入参处理后的返回值泛型
     * @param <B> 业务处理后返回值泛型
     * @param <T> 接口出参泛型
     */
    public static <D, B, T> ApiResult<T> okParamResult(Supplier<D> paramSupplier, Function<D, B> business, Function<B, T> resultDeal) {
        return ApiResult.<T>builder()
                .code(ResponseCode.SUCCESS)
                .data(resultDeal.apply(business.apply(paramSupplier.get())))
                .build();
    }

    /**
     * 失败:服务器异常
     * @return
     */
    public static ApiResult<Void> fail() {
        return ApiResult.<Void>builder()
                .code(ResponseCode.FAIL)
                .msg("Server Error")
                .build();
    }
}
