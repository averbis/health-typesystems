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
package de.averbis.textanalysis.types.health;

import static aQute.bnd.annotation.Resolution.OPTIONAL;

import org.apache.uima.spi.TypeSystemProvider;
import org.apache.uima.spi.TypeSystemProvider_ImplBase;

import aQute.bnd.annotation.spi.ServiceProvider;

@ServiceProvider(value = TypeSystemProvider.class, resolution = OPTIONAL)
public class HealthTypeSystemDescriptionProvider extends TypeSystemProvider_ImplBase {

	public HealthTypeSystemDescriptionProvider() {

		setTypeSystemLocations( //
				"AnatomyTypeSystem.xml", //
				"ClinicalSectionTypeSystem.xml", //
				"DiagnosisTypeSystem.xml", //
				"EHRInformationTypeSystem.xml", //
				"HealthTypeSystem.xml", //
				"InternalTypeSystem.xml", //
				"LaboratoryValueTypeSystem.xml", //
				"MedicalDisambiguationTypeSystem.xml", //
				"MedicalNegationTypeSystem.xml", //
				"MedicationTypeSystem.xml", //
				"ObservationTypeSystem.xml", //
				"OncologyTypeSystem.xml", //
				"PathologyTypeSystem.xml", //
				"PatientInformationTypeSystem.xml", //
				"PHITypeSystem.xml", //
				"ProcedureTypeSystem.xml", //
				"TherapyTypeSystem.xml", //
				"TNMTypeSystem.xml");
	}
}
