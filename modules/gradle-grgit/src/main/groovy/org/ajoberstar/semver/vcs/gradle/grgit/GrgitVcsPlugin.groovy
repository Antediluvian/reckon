/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajoberstar.semver.vcs.gradle.grgit

import org.ajoberstar.grgit.Grgit
import org.ajoberstar.semver.vcs.grgit.GrgitVcs
import org.gradle.api.Plugin
import org.gradle.api.Project

class GrgitVcsPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.pluginManager.apply('org.ajoberstar.grgit')
        project.pluginManager.apply('org.ajoberstar.semver-vcs-base')

        project.extensions.getByName('semver').with {
            vcs = new GrgitVcs(project.grgit)
        }
    }
}