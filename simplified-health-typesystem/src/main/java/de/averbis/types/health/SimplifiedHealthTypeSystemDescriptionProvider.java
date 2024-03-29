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
package de.averbis.types.health;

import static org.apache.uima.util.TypeSystemUtil.loadTypeSystemDescriptionsFromClasspath;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.metadata.TypeDescription;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.apache.uima.spi.JCasClassProvider;
import org.apache.uima.spi.TypeSystemDescriptionProvider;

public class SimplifiedHealthTypeSystemDescriptionProvider
		implements TypeSystemDescriptionProvider, JCasClassProvider {

	@Override
	public List<TypeSystemDescription> listTypeSystemDescriptions() {

		return loadTypeSystemDescriptionsFromClasspath(getClass(), //
				"SimplifiedHealthTypeSystem.xml");
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Class<? extends TOP>> listJCasClasses() {

		List<Class<? extends TOP>> classes = new ArrayList<>();
		ClassLoader cl = getClass().getClassLoader();

		List<TypeSystemDescription> typeSystemDescriptions = listTypeSystemDescriptions();
		for (TypeSystemDescription tsd : typeSystemDescriptions) {
			for (TypeDescription td : tsd.getTypes()) {
				try {
					classes.add((Class<? extends TOP>) cl.loadClass(td.getName()));
				} catch (ClassNotFoundException e) {
					// This is acceptable - there may not be a JCas class
				}
			}
		}

		return classes;
	}
}
