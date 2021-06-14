package com.adnankuru.englishpremierleague.data;

import lombok.Data;

@Data
public class MatchInput {

    private String Id;
    private String Date;
    private String HomeTeam;
    private String AwayTeam;
    private String FTHG;
    private String FTAG;
    private String FTR;
    private String HTGS;
    private String ATGS;
    private String HTGC;
    private String ATGC;
    private String HTP;
    private String ATP;
    private String HM1;
    private String HM2;
    private String HM3;
    private String HM4;
    private String HM5;
    private String AM1;
    private String AM2;
    private String AM3;
    private String AM4;
    private String AM5;
    private String MW;
    private String HTFormPtsStr;
    private String ATFormPtsStr;
    private String HTFormPts;
    private String ATFormPts;
    private String HTWinStreak3;
    private String HTWinStreak5;
    private String HTLossStreak3;
    private String HTLossStreak5;
    private String ATWinStreak3;
    private String ATWinStreak5;
    private String ATLossStreak3;
    private String ATLossStreak5;
    private String HTGD;
    private String ATGD;
    private String DiffPts;
    private String DiffFormPts;
}
