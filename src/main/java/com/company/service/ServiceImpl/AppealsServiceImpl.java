package com.company.service.ServiceImpl;

import com.company.entity.Appeals;
import com.company.payload.ApiResponse;
import com.company.payload.AppealsDto;
import com.company.repository.AppealsRepository;
import com.company.service.AppealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppealsServiceImpl implements AppealsService {
    @Autowired
    private AppealsRepository appealsRepository;

    @Override
    public ApiResponse appealAdd(AppealsDto appealsDto) {
        Appeals appeals=new Appeals();
        appeals.setText(appealsDto.getText());
        appeals.setEmail(appealsDto.getEmail());
        appeals.setFullName(appealsDto.getFullName());

        appealsRepository.save(appeals);
        return new ApiResponse("add appeals success", true);
    }

    @Override
    public ApiResponse deleteAppeals(Long id) {
        try{
            appealsRepository.deleteById(id);
            return new ApiResponse("delete Appeals",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Appeals appealsById(Long id) {
        return appealsRepository.findById(id).orElse(new Appeals());
    }

    @Override
    public Page<Appeals> Allappeals(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return appealsRepository.findAll(pageable);
    }
}
