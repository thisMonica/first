package com.example.first.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author hu
 * @date 2020/4/14 16:18
 */
@Data
@Builder
public class SupportedResult implements Serializable {

    private static final long serialVersionUID = 6348371651666208258L;

    private String systemId;

    private String platform;

    private List<CoinSupported> coinSupported;

    private List<CurSupported> curSupported;
}
