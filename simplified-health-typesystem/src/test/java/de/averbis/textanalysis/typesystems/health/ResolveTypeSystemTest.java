/*
 * Copyright 2022 Averbis GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.averbis.textanalysis.typesystems.health;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ServiceLoader;

import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.spi.TypeSystemProvider;
import org.junit.jupiter.api.Test;

import de.averbis.types.health.SimplifiedHealthTypeSystemDescriptionProvider;

class ResolveTypeSystemTest {

	@Test
	void thatTypeSystemCanBeAutoDetectedAndResolved() throws Exception {

		var tsd = TypeSystemDescriptionFactory
				.createTypeSystemDescription("de.averbis.types.health.SimplifiedHealthTypeSystem");
		tsd.resolveImports();
		assertThat(tsd.getTypes()).hasSize(87);
	}


	@SuppressWarnings("unchecked")
	@Test
	void thatSpiDetectionWorks() {

		var loader = ServiceLoader.load(TypeSystemProvider.class);

		assertThat(loader) //
				.extracting(Object::getClass) //
				.contains((Class) SimplifiedHealthTypeSystemDescriptionProvider.class);
	}
}
