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

package com.mygdx.game.objects.dog;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameEngine;
import com.mygdx.game.objects.DogCharacter;
import com.mygdx.game.objects.HumanCharacter;

/**
 * @author davebaol
 */
public class CalculatePathToHumanTask extends LeafTask<DogCharacter> {

	private static final Vector3 tmp1 = new Vector3();
	private static final Vector3 tmp2 = new Vector3();
	
	public CalculatePathToHumanTask () {
	}

	@Override
	public Status execute () {
		DogCharacter dog = getObject();
		HumanCharacter human = dog.human;
		if (GameEngine.engine.getScene().navMesh.getPath(
				dog.currentTriangle,
				dog.getGroundPosition(tmp1),
				human.currentTriangle,
				human.getGroundPosition(tmp2),
				dog.navMeshGraphPath)) {
			
			dog.calculateNewPath();
			//success();
		}
		return Status.SUCCEEDED;
	}

	@Override
	protected Task<DogCharacter> copyTo (Task<DogCharacter> task) {
		return task;
	}

}