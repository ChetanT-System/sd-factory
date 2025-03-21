/********************************************************************************
 * Copyright (c) 2022,2025 T-Systems International GmbH
 * Copyright (c) 2022,2025 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.tractusx.selfdescriptionfactory.service.converter;

import org.eclipse.tractusx.selfdescriptionfactory.model.tagus.RegistrationNumberSchema;

import java.util.Map;
import java.util.function.Function;

public class RegCodeMapper {

    private final String prefix;
    private RegCodeMapper(String prefix){
        this.prefix = prefix;
    }
    private static final Map<RegistrationNumberSchema.TypeEnum, String> regCodeMapper = Map.of(
            RegistrationNumberSchema.TypeEnum.TAXID, "taxID",
            RegistrationNumberSchema.TypeEnum.LOCAL, "local",
            RegistrationNumberSchema.TypeEnum.VATID, "vatID",
            RegistrationNumberSchema.TypeEnum.EUID, "EUID",
            RegistrationNumberSchema.TypeEnum.EORI, "EORI",
            RegistrationNumberSchema.TypeEnum.LEICODE, "leiCode"
    );

    public String get(RegistrationNumberSchema.TypeEnum type) {
        return prefix.concat(regCodeMapper.get(type));
    }

    public static Function<RegistrationNumberSchema.TypeEnum, String> getRegCodeMapper(String prefix) {
        return new RegCodeMapper(prefix)::get;
    }
}
