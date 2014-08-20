/**    / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang;

import static javaslang.Assertions.assertThat;
import javaslang.Requirements.UnsatisfiedRequirementException;

import org.junit.Test;

public class RequirementsTest {

	@Test
	public void shouldNotInstantiable() {
		assertThat(Requirements.class).isNotInstantiable();
	}

	@Test
	public void shouldPassOnTrueCondition() {
		Requirements.require(true, "you will never see this");
	}

	@Test(expected = UnsatisfiedRequirementException.class)
	public void shouldThrowOnFalseCondition() {
		Requirements.require(false, "expected");
	}

	@Test(expected = Error.class)
	public void shouldEvaluateNonLambdas() {
		Requirements.require(true, getMessage());
	}

	@Test
	public void shouldNotEvaluateLambdas() {
		Requirements.require(true, () -> getMessage());
	}

	private String getMessage() {
		throw new Error();
	}

}
