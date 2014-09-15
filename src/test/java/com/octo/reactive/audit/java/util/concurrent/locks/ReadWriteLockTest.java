/*
 * Copyright 2014 OCTO Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.octo.reactive.audit.java.util.concurrent.locks;

import com.octo.reactive.audit.AuditReactive;
import com.octo.reactive.audit.lib.CPUAuditReactiveException;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLockTest
{
	private final ReadWriteLock c = new ReadWriteLock()
	{

		@Override
		public Lock readLock()
		{
			return null;
		}

		@Override
		public Lock writeLock()
		{
			return null;
		}
	};

	@Test(expected = CPUAuditReactiveException.class)
	public void readLock() throws InterruptedException
	{
		AuditReactive.strict.commit();
		c.readLock();
	}

	@Test(expected = CPUAuditReactiveException.class)
	public void writeLock() throws InterruptedException
	{
		AuditReactive.strict.commit();
		c.writeLock();
	}

}
