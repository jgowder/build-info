/*
 * Copyright (C) 2012 JFrog Ltd.
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

package org.jfrog.build.api.builder.dependency;

import com.google.common.collect.Lists;
import org.jfrog.build.api.dependency.BuildDependency;
import org.jfrog.build.api.dependency.BuildOutputs;
import org.jfrog.build.api.dependency.PatternResult;

import java.util.List;

/**
 * @author jbaruch
 * @since 16/02/12
 */
public class BuildOutputsBuilder {
    private String buildName;
    private String buildNumber;
    private List<BuildDependency> buildDependencies;
    private List<PatternResult> patternResults;

    public BuildOutputsBuilder() {
        buildDependencies = Lists.newArrayList();
        patternResults = Lists.newArrayList();
    }

    public BuildOutputs build() {
        if (buildName == null) {
            throw new IllegalArgumentException("BuildOutputs must have a name.");
        }
        if (buildNumber == null) {
            throw new IllegalArgumentException("BuildOutputs must have a number.");
        }
        BuildOutputs buildOutputs = new BuildOutputs(buildName, buildNumber);
        buildOutputs.setBuildDependencies(buildDependencies);
        buildOutputs.setPatternResults(patternResults);
        return buildOutputs;
    }

    public BuildOutputsBuilder buildName(String buildName) {
        this.buildName = buildName;
        return this;
    }

    public BuildOutputsBuilder buildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
        return this;
    }

    public BuildOutputsBuilder buildDependency(BuildDependency buildDependency) {
        buildDependencies.add(buildDependency);
        return this;
    }

    public BuildOutputsBuilder patternResult(PatternResult patternResult) {
        patternResults.add(patternResult);
        return this;
    }
}
