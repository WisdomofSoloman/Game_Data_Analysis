package org.example.playerdataanalysiswebservice.dto;

public class OverallWinRateDTO {
    private double pvpWinRate;   // 0–100
    private double pveWinRate;   // 0–100

    public OverallWinRateDTO(double pvp, double pve) {
        this.pvpWinRate = pvp;
        this.pveWinRate = pve;
    }
    public double getPvpWinRate() { return pvpWinRate; }
    public double getPveWinRate() { return pveWinRate; }
}
