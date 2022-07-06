package br.com.gerenciador.api;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.gerenciador.api.dto.PlanetaDTO;
import br.com.gerenciador.api.entity.PessoaEntity;
import br.com.gerenciador.api.repository.PessoaRepository;
import br.com.gerenciador.api.controller.PessoaController;
import br.com.gerenciador.api.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenciadorTarefaApplicationTests {
	
	@Autowired
	public PessoaRepository repository;
	
	@Autowired
	public PessoaService service;
	
	@Autowired
	public PessoaController resource;
	
	public MockMvc mockMvc;

	
	public PlanetaDTO mockPessoa() {
		
		PessoaEntity entity = new PessoaEntity();
		PlanetaDTO dto = new PlanetaDTO();
		
		entity.setId(1L);
		entity.setClimate("SOL");
		entity.setName("Naboo");
		entity.setQuantity("4");
		entity.setTerrain("plana");
		
		dto.setId(entity.getId());
		dto.setClima(entity.getClimate());
		dto.setNome(entity.getName());
		dto.setIdSWAPI(entity.getQuantity());
		dto.setTerreno(entity.getTerrain());
		
		return dto;
	}
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}
	
}
