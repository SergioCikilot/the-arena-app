package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.PitchService;
import draft1.TheArenaApp1.dataAccess.PitchDao;
import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PitchManager implements PitchService {

    private PitchDao pitchDao;


    public PitchManager() {
    }

    @Autowired
    public PitchManager(PitchDao pitchDao) {
        this.pitchDao = pitchDao;
    }

    @Override
    public List<Pitch> getAllPitches() {
        return pitchDao.findAll();
    }

    @Override
    public List<Pitch> getAllPitchesWithPage(int pageNo, int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNo,pageSize);

        return this.pitchDao.findAll(pageable).getContent();
    }

    @Override
    public void addPitch(Pitch pitch) {

        this.pitchDao.save(pitch);

    }

    @Override
    public void deletePitch(Pitch pitch) {

        this.pitchDao.delete(pitch);

    }

    @Override
    public void updatePitchOpeningTime(String openingTime, int pitchId) {

        this.pitchDao.updatePitchOpeningTime(openingTime,pitchId);

    }

    @Override
    public void updatePitchClosingTime(String closingTime, int pitchId) {

        this.pitchDao.updatePitchClosingTime(closingTime,pitchId);

    }

    @Override
    public void updatePitchMatchDuration(String matchDuration, int pitchId) {

        this.pitchDao.updatePitchMatchDuration(matchDuration,pitchId);

    }


}
