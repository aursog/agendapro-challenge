package com.agendapro.challenge.service.impl;

import com.agendapro.challenge.dto.UserDto;
import com.agendapro.challenge.dto.mappers.UserMapper;
import com.agendapro.challenge.dto.request.UserRequest;
import com.agendapro.challenge.exceptions.EmailExistsException;
import com.agendapro.challenge.exceptions.PasswordValidationException;
import com.agendapro.challenge.model.Phone;
import com.agendapro.challenge.model.User;
import com.agendapro.challenge.repository.PhoneRepository;
import com.agendapro.challenge.repository.UserRepository;
import com.agendapro.challenge.service.UserService;
import com.agendapro.challenge.utils.PasswordValidator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PhoneRepository phoneRepository;
  private final PasswordValidator passwordValidator;

  @Override
  public UserDetailsService userDetailsService() {
    return (username) -> userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Override
  public User create(UserRequest userRequest) {
    if (this.userRepository.findByEmail(userRequest.email()).isPresent())
      throw new EmailExistsException("El correo ya se encuentra registrado");

    if (!passwordValidator.validatePassword(userRequest.password()))
      throw new PasswordValidationException("La contraseña es inválida");

    User user = userRepository.save(UserMapper.fromRequestToEntity(userRequest));

    userRequest.phones().forEach(it -> phoneRepository.save(
        new Phone(it.number(), it.citycode(), it.countrycode(), user)
    ));

    return user;
  }

  @Override
  public List<UserDto> list() {
    return this.userRepository.findAll()
        .stream().map(UserMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public UserDto get(UUID uuid) {
    return this.userRepository.findById(uuid)
        .map(UserMapper::toDto)
        .orElseThrow(() -> new UsernameNotFoundException("User not found " + uuid));
  }

  @Override
  public User loadUserByUsername(String username) {
    return userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
