package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);
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
            if(LOGGER.isWarnEnabled()){
                LOGGER.warn("Transaction has failed, all changes have been rolled back.");
            }
            throw new RuntimeException("Unable to read from DB", e);
        }
        return partnerDto;
    }
}
