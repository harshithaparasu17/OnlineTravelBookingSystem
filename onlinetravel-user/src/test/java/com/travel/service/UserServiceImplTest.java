package com.travel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.User;
import com.travel.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;

	@Test
	@DisplayName("Test- to verify the insert operation")
	void testInsertUser() throws Exception {
		User sampleInput = new User("shilpa", "fg", "admin");
		User expectedOutput = new User("shilpa", "fg", "admin");
		BDDMockito.given(userService.insertUser(sampleInput)).willReturn(expectedOutput);

		User actualOutput = userService.insertUser(sampleInput);

		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@DisplayName("Get all the users")
	void testGetAllUsers() throws Exception {
		User user1 = new User("shilpa", "fg", "admin");
		User user2 = new User("dinesh", "kfid", "admin");

		List<User> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);

		BDDMockito.given(userService.getAllUsers()).willReturn(sampleOutput);
		// when :- readyto test the funcationality (service)
		List<User> actualOutput = userService.getAllUsers();

		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull(); // or
		assertNotNull(actualOutput);
		// assertThat(actualOutput.size()).isGreaterThan(0);

		assertIterableEquals(sampleOutput, actualOutput);

	}

	
	@Test
	@DisplayName("Test to verify the method getUser by Id should return User or not")
	void testGetUserByUserId() throws Exception {
		User sampleOutput = new User("shilpa", "fg", "admin");
		sampleOutput.setUserId(1);

		int sampleInput = 1;

		BDDMockito.given(userService.getUserByUserId(sampleInput)).willReturn(sampleOutput);

		// when
		User actualOutput = userService.getUserByUserId(sampleInput);

		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getUserId(), actualOutput.getUserId());
		// assertThat(actualOutput.getUserId()).isGreaterThan(0);

	}

	@Test
	@DisplayName("Get all users between id")
	void testGetUsersBetweenIds() throws Exception {
		User user1 = new User("shilpa", "fg", "admin");
		User user2 = new User("dinesh", "kfid", "admin");

		List<User> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);

		int sampleInput1 = 1;
		int sampleInput2 = 20;

		BDDMockito.given(userService.getUsersBetweenIds(sampleInput1, sampleInput2)).willReturn(sampleOutput);
		/// when
		List<User> actualOutput = userService.getUsersBetweenIds(sampleInput1, sampleInput2);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);

	}

}
