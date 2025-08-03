package Api_dio.dev.service.Impl;

import Api_dio.dev.domain.model.Pessoa;
import Api_dio.dev.domain.repository.PessoaRepository;
import Api_dio.dev.service.exception.BusinessException;
import Api_dio.dev.service.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class Serviceimpl {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final PessoaRepository pessoaRepository;


    public Serviceimpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public Pessoa findById(Long id) {
        return this.pessoaRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Pessoa create(Pessoa userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));

        return this.pessoaRepository.save(userToCreate);
    }

    @Transactional
    public Pessoa update(Long id, Pessoa userToUpdate) {
        Pessoa dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setNome(userToUpdate.getNome());
        dbUser.getEndereco().setLogradouro(userToUpdate.getEndereco().getLogradouro());
        dbUser.getEndereco().setNumero(userToUpdate.getEndereco().getNumero());
        dbUser.getEndereco().setComplemento(userToUpdate.getEndereco().getComplemento());
        dbUser.getEndereco().setCidade(userToUpdate.getEndereco().getCidade());
        dbUser.getEndereco().setBairro(userToUpdate.getEndereco().getBairro());
        dbUser.getEndereco().setCep(userToUpdate.getEndereco().getCep());
        return this.pessoaRepository.save(dbUser);
    }


    @Transactional
    public void delete(Long id) {
        Pessoa dbUser = this.findById(id);
        this.pessoaRepository.delete(dbUser);
    }
}
