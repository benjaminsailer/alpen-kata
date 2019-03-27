package de.iteconomics.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MountainDAOTest {

	@Test
	public void testReadAll() {
		MountainDAO dao = new MountainDAO();
		assertEquals(7, dao.getMountains("Frankreich", 0, 8000).size());
	}
}
