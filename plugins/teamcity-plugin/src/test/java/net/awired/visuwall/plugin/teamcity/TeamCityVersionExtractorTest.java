/**
 *     Copyright (C) 2010 Julien SMADJA <julien dot smadja at gmail dot com> - Arnaud LEMAIRE <alemaire at norad dot fr>
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package net.awired.visuwall.plugin.teamcity;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.google.common.io.ByteStreams;

public class TeamCityVersionExtractorTest {

	@Test
	public void should_extract_version_in_teamcity_page() throws IOException {
		Class<? extends TeamCityVersionExtractorTest> clazz = this.getClass();
		ClassLoader classLoader = clazz.getClassLoader();
		InputStream stream = classLoader.getResourceAsStream("teamcity_version_page.xml");
		byte[] data = ByteStreams.toByteArray(stream);
		TeamCityVersionExtractor tve = new TeamCityVersionExtractor(new String(data));

		String version = tve.version();
		assertEquals("6.5", version);
	}

}
