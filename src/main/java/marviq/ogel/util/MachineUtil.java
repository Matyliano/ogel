package marviq.ogel.util;

import marviq.ogel.entity.Machine2x2;
import marviq.ogel.entity.Machine3x2;
import org.springframework.stereotype.Service;

@Service
public class MachineUtil {

    public double countingTotalNetProduction2x2(){
        Machine2x2 machine2x2 = new Machine2x2();
        double gross =  machine2x2.getGrossProduction();
        double scrap = machine2x2.getScrap();
        double totalNetProduction = gross - scrap;
        return totalNetProduction;
    }

    public double percentageOfScrapVsGrossProduction2x2(){
        Machine2x2 machine2x2 = new Machine2x2();
        double scrap = machine2x2.getScrap();
        double gross = machine2x2.getGrossProduction();
        double percentage = scrap/gross;
        return percentage;
    }

    public double countingTotalNetProduction3x2(){
        Machine3x2 machine3x2 = new Machine3x2();
        double gross =  machine3x2.getGrossProduction();
        double scrap = machine3x2.getScrap();
        double totalNetProduction = gross - scrap;
        return totalNetProduction;
    }

    public double percentageOfScrapVsGrossProduction3x2(){
        Machine3x2 machine3x2 = new Machine3x2();
        double scrap = machine3x2.getScrap();
        double gross = machine3x2.getGrossProduction();
        double percentage = scrap/gross;
        return percentage;
    }

}
