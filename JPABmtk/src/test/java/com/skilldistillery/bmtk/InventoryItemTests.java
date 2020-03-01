package com.skilldistillery.bmtk;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.bmtk.entities.InventoryItem;
import com.skilldistillery.bmtk.entities.Task;

class InventoryItemTests {
	private EntityManager em;
	private static EntityManagerFactory emf;
	private InventoryItem item;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("bmtk");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		item = em.find(InventoryItem.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		item = null;
	}

	@Test
	void test() {
		assertNotNull(item);
		assertEquals("test item", item.getName());
	}
	
	@Test
	void testingCompany() {
		assertEquals("Test Company", item.getCompany().getName());
	}

}
