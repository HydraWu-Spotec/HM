package cn.com.uestc.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVO<T> {

    private Long page;

    private Long size;

    private List<T> data;

    public static <T> PageVO<T> of(Long page, Long size, List<T> data) {
        return PageVO.<T>builder().page(page).size(size).data(data).build();
    }
}
