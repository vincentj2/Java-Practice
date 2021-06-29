import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.TemporalAdjusters.*;

public class main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2021,7,2);
        LocalDate date1 = date.with(lastDayOfMonth());
        LocalDate date2 = date.with(firstDayOfNextYear());
        LocalDate date3 = date.with(new NextWorkingDay());

        System.out.println(date3);

    }

    //퀴즈 12-2
    private static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int AddDay =1;
            if(dow == DayOfWeek.FRIDAY){
                AddDay =3;
            }else if (dow == DayOfWeek.SATURDAY){
                AddDay =2;
            }
            return temporal.plus(AddDay, ChronoUnit.DAYS);
        }
    }
}
