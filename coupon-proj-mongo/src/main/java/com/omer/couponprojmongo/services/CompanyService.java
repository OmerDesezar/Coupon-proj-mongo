package com.omer.couponprojmongo.services;

import com.omer.couponprojmongo.exceptions.AlreadyExistsException;
import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.Company;
import com.omer.couponprojmongo.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class CompanyService implements EntityService<Company> {

    private CompanyRepository repository;

    public boolean isCompanyExists(String email, String password) {
        return repository.existsByEmailAndPassword(email, password);
    }

    public Optional<Company> findByEmail(String email){
        return repository.findByEmail(email);
    }

    @Override
    public Company save(Company company) throws AlreadyExistsException {
        if (repository.existsByName(company.getName())){
            throw new AlreadyExistsException("A company with the name " + company.getName() + " already exists");
        }
        return repository.save(company);
    }

    @Override
    public Optional<Company> findById(String companyId) {
        return repository.findById(companyId);
    }

    public Company findByName(String name) throws NotExistsException{
        return repository
                .findByName(name)
                .orElseThrow(()-> new NotExistsException(
                        "A company with the name " + name + " doesnt exist")
                );
    }

    public String getIdByName(String companyName)throws NotExistsException{
        return repository.findByName(companyName)
                .map(Company::getId)
                .orElseThrow(()->
                        new NotExistsException("A company with the name " + companyName + " doesnt exist"));
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    public Company updateCompany(Function<Company, Company> mapper, String companyId) throws NotExistsException {
        return findById(companyId)
                .map(byId -> mapper
                        .andThen(repository::save)
                        .apply(byId))
                .orElseThrow(() -> new NotExistsException(
                        "A comapny with the ID " + companyId + " doesnt exist"));
    }

    public Company deleteCompany(String companyId) throws NotExistsException {
        return findById(companyId)
                .map(company -> {
                    repository.delete(company);
                    return company;
                }).orElseThrow(() -> new NotExistsException("A company with the ID " + companyId + " doesnt exist"));
    }
}
