package com.company.service.ServiceImpl;

import com.company.entity.Vacancies;
import com.company.payload.ApiResponse;
import com.company.payload.VacanciesDto;
import com.company.repository.VacanciesRepository;
import com.company.service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacanciesServiceImpl implements VacanciesService {
    @Autowired
    private VacanciesRepository vacanciesRepository;

    @Override
    public ApiResponse addVacancie(VacanciesDto vacanciesDto) {

        Vacancies vacancies=new Vacancies();
        vacancies.setDescriptionEN(vacanciesDto.getDescriptionEN());
        vacancies.setDescriptionRU(vacanciesDto.getDescriptionRU());
        vacancies.setDescriptionKR(vacanciesDto.getDescriptionKR());
        vacancies.setDescriptionUZ(vacanciesDto.getDescriptionUZ());
        vacancies.setNameKR(vacanciesDto.getNameKR());
        vacancies.setNameEN(vacanciesDto.getNameEN());
        vacancies.setNameRU(vacanciesDto.getNameRU());
        vacancies.setNameUZ(vacanciesDto.getNameUZ());
        vacancies.setSalary(vacanciesDto.getSalary());
        vacanciesRepository.save(vacancies);
        return new ApiResponse("add vacancises success", true);

    }

    @Override
    public ApiResponse editVacancie(Long id, VacanciesDto vacanciesDto) {
        Optional<Vacancies> optionalVacancies = vacanciesRepository.findById(id);
        if (!optionalVacancies.isPresent()){
            return new ApiResponse("not found vacancies", false);
        }
        Vacancies vacancies = optionalVacancies.get();
        vacancies.setDescriptionEN(vacanciesDto.getDescriptionEN());
        vacancies.setDescriptionRU(vacanciesDto.getDescriptionRU());
        vacancies.setDescriptionKR(vacanciesDto.getDescriptionKR());
        vacancies.setDescriptionUZ(vacanciesDto.getDescriptionUZ());
        vacancies.setNameKR(vacanciesDto.getNameKR());
        vacancies.setNameEN(vacanciesDto.getNameEN());
        vacancies.setNameRU(vacanciesDto.getNameRU());
        vacancies.setNameUZ(vacanciesDto.getNameUZ());
        vacancies.setSalary(vacanciesDto.getSalary());
        vacanciesRepository.save(vacancies);

        return new ApiResponse("edit vacancises success", true);
    }

    @Override
    public ApiResponse deleteVacancie(Long id) {
        try{
            vacanciesRepository.deleteById(id);
            return new ApiResponse("delete vacancies",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Vacancies vacanciegetByid(Long id) {
        return vacanciesRepository.findById(id).orElse(new Vacancies());
    }

    @Override
    public List<Vacancies> allVacancie() {
        return vacanciesRepository.findAll();
    }
}
