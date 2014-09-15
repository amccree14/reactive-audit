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

package com.octo.reactive.audit.javax.xml.bind;

import com.octo.reactive.audit.AuditReactive;
import com.octo.reactive.audit.IOTestTools;
import com.octo.reactive.audit.lib.FileAuditReactiveException;
import org.junit.Test;

import javax.xml.bind.JAXB;
import java.net.MalformedURLException;

public class JAXBTest
{
	@Test(expected = FileAuditReactiveException.class)
	public void marshal_File()
	{
		AuditReactive.strict.commit();
		JAXB.marshal(null, IOTestTools.getTempFile());
	}

	@Test(expected = FileAuditReactiveException.class)
	public void marshal_OutputStream()
	{
		AuditReactive.strict.commit();
		JAXB.marshal(null, IOTestTools.getTempFileOutputStream());
	}

	@Test(expected = FileAuditReactiveException.class)
	public void marshal_Writer()
	{
		AuditReactive.strict.commit();
		JAXB.marshal(null, IOTestTools.getTempFileWriter());
	}

	@Test(expected = FileAuditReactiveException.class)
	public void marshal_URL() throws MalformedURLException
	{
		AuditReactive.strict.commit();
		JAXB.marshal(null, IOTestTools.getTempFile().toURI().toURL());
	}

	@Test(expected = FileAuditReactiveException.class)
	public void unmarshal_File()
	{
		AuditReactive.strict.commit();
		JAXB.unmarshal(IOTestTools.getTempFile(), null);
	}

	@Test(expected = FileAuditReactiveException.class)
	public void unmarshal_InputStream()
	{
		AuditReactive.strict.commit();
		JAXB.unmarshal(IOTestTools.getTempFileInputStream(), null);
	}

	@Test(expected = FileAuditReactiveException.class)
	public void unmarshal_Reader()
	{
		AuditReactive.strict.commit();
		JAXB.unmarshal(IOTestTools.getTempFileReader(), null);
	}

	@Test(expected = FileAuditReactiveException.class)
	public void unmarshal_URL() throws MalformedURLException
	{
		AuditReactive.strict.commit();
		JAXB.unmarshal(IOTestTools.getTempFile().toURI().toURL(), null);
	}
}
