package cn.com.uestc.base;

import lombok.Data;

/**
 * 通用键值对
 * @param <K>
 * @param <V>
 */
@Data
public class KVPair<K, V> {

    private K key;

    private V val;
}
