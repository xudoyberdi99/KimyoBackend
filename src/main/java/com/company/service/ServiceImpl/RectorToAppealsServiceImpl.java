package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.RectorToAppeals;
import com.company.payload.ApiResponse;
import com.company.payload.RectorToAppealsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.RectorToAppealsRepository;
import com.company.service.RectorToAppealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RectorToAppealsServiceImpl implements RectorToAppealsService {
    @Autowired
    private RectorToAppealsRepository rectorToAppealsRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public ApiResponse appealAdd(RectorToAppealsDto rectorToAppealsDto) {
        RectorToAppeals rectorToAppeals=new RectorToAppeals();
        rectorToAppeals.setText(rectorToAppealsDto.getText());
        rectorToAppeals.setEmail(rectorToAppealsDto.getEmail());
        rectorToAppeals.setLastname(rectorToAppealsDto.getLastName());
        rectorToAppeals.setFirstname(rectorToAppealsDto.getFirstName());
        rectorToAppeals.setPhoneNumber(rectorToAppealsDto.getPhonrNumber());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(rectorToAppealsDto.getAttachment());
        if (!optional.isPresent()){
            rectorToAppeals.setAttachment(null);
        }
        rectorToAppeals.setAttachment(optional.get());

        rectorToAppealsRepository.save(rectorToAppeals);

        return new ApiResponse("success message", true);
    }

    @Override
    public ApiResponse deleteAppeals(Long id) {
        try{
            rectorToAppealsRepository.deleteById(id);
            return new ApiResponse("delete Appeals",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public RectorToAppeals appealsById(Long id) {
        return rectorToAppealsRepository.findById(id).orElse(new RectorToAppeals());
    }

    @Override
    public Page<RectorToAppeals> Allappeals(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return rectorToAppealsRepository.findAll(pageable);
    }
}
