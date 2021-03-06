/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.mygdx.game.objects;

import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Bits;
import com.mygdx.game.utilities.Entity;

/**
 * @author jsjolund
 */
public abstract class GameObject extends Entity {
	public final String name;

	public GameObject(String name) {
		this.name = name;
	}

	public abstract void update(float deltaTime);

	public abstract void dispose();

	public void handleMovementRequest(Ray ray, Bits visibleLayers) {
	}
}
