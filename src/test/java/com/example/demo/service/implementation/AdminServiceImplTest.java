package com.example.demo.service.implementation;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {
    private AdminServiceImpl underTest;

    @Mock
    private AdminRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
         underTest = new AdminServiceImpl(repository);
    }
    @Test
    void findAllAdmins() {
        List<Admin> admins = List.of(new Admin(), new Admin());
        when(repository.findAll()).thenReturn(admins);
        assertEquals(2,  underTest.findAllAdmins().size());
    }
 //fakeDataDao = repository
//user service = underTest
    @Test
    void saveAdmin() {
        Admin admin = AdminDto.toEntity(AdminDto.fromEntity(new Admin()));
        underTest.saveAdmin(AdminDto.fromEntity(admin));
        ArgumentCaptor<Admin> adminArgumentCaptor = ArgumentCaptor.forClass(Admin.class);
        verify(repository).save(adminArgumentCaptor.capture());
        Admin capturedAdmin = adminArgumentCaptor.getValue();
        assertThat(capturedAdmin).isEqualTo(admin);

    }

//    @Test
//    void updateAdminbyId() {
//        Admin admin = new Admin(5, "admin", "root", "admin");
//       given(repository.findById(admin.getIdAdmin())).willReturn(Optional.of(admin));
//       given(repository.updateAdmin(admin)).willReturn(1);
//        ArgumentCaptor<Admin> captor = ArgumentCaptor.forClass(Admin.class);
//       int result= underTest.updateAdminbyId(admin.getIdAdmin(),admin).getIdAdmin();
//       verify(repository).findById(admin.getIdAdmin());
//       verify(repository).updateAdmin(captor.capture());
//       Admin adminCap= captor.getValue();
//
//       assertEquals(result , 1);
//    }

}