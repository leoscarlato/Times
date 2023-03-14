package insper.times.Time;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time getTimeByIdentifier(String identifier) {
        return timeRepository.findByIdentifier(identifier);
    }

    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    public Time postTime(Time time) {
        timeRepository.save(time);
        // String identifier = UUID.randomUUID().toString();
        // time.setIdentifier(identifier);
        return time;
    }
    
}