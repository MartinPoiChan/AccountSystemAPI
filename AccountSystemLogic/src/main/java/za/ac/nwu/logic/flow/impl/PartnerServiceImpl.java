package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.Partner;
import za.ac.nwu.logic.flow.PartnerService;
import za.ac.nwu.repo.persistence.PartnerRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class PartnerServiceImpl implements PartnerService {
    private PartnerRepository partnerRepository;

    @Autowired
    public PartnerServiceImpl(PartnerRepository partnerRepository){
        this.partnerRepository = partnerRepository;
    }

    @Override
    public PartnerDto getOnePartner(long id) {
        PartnerDto partnerDto;
        try {
            partnerDto = new PartnerDto(partnerRepository.getOne(id));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
        return partnerDto;
    }
}
