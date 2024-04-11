package com.magic.model;

import lombok.Data;

/**
 * 静态模版配置
 */
@Data
public class MainTemplateConfig {
    /**
     * 作者
     */
    private String author = "magic";
    /**
     * 输出信息
     */
    private String outputText = "输出结果";
    /**
     * 是否循环（开关）
     */
    private boolean loop;
}
