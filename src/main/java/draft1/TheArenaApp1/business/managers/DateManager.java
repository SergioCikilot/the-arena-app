package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.DateService;
import draft1.TheArenaApp1.core.utilities.DateAndTime.DateAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateManager implements DateService {

    private DateAdapter dateAdapter;

    @Autowired
    public DateManager(DateAdapter dateAdapter) {
        this.dateAdapter = dateAdapter;
    }

    @Override
    public String getFormattedCurrentTime12Hour() {
        return this.dateAdapter.getFormattedCurrentTime12Hour();
    }

    @Override
    public String getFormattedCurrentTime24Hour() {
        return this.dateAdapter.getFormattedCurrentTime24Hour();
    }

    @Override
    public String getFormattedCurrentTimeIstanbul24Hour() {
        return this.dateAdapter.getFormattedCurrentTimeIstanbul24Hour();
    }

    @Override
    public String getFormattedCurrentDateIstanbul() {
        return this.dateAdapter.getFormattedCurrentDateIstanbul();
    }
}
