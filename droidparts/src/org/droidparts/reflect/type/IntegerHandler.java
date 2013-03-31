/**
 * Copyright 2013 Alex Yanchenko
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
package org.droidparts.reflect.type;

import static org.droidparts.util.Arrays2.toPrimitive;

import java.util.ArrayList;

import org.droidparts.reflect.util.TypeHelper;

import android.content.ContentValues;
import android.database.Cursor;

public class IntegerHandler extends TypeHandler<Integer> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isInteger(cls);
	}

	@Override
	public String getDBColumnType() {
		return INTEGER;
	}

	@Override
	protected <V> Integer parseFromString(Class<Integer> valType,
			Class<V> arrCollItemType, String str) {
		return Integer.valueOf(str);
	}

	@Override
	public <V> void putToContentValues(Class<Integer> valueType,
			Class<V> arrCollItemType, ContentValues cv, String key, Integer val) {
		cv.put(key, val);
	}

	@Override
	public <V> Integer readFromCursor(Class<Integer> valType,
			Class<V> arrCollItemType, Cursor cursor, int columnIndex) {
		return cursor.getInt(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<Integer> valType, String[] arr) {
		ArrayList<Integer> list = parseTypeColl(valType, arr);
		Integer[] tArr = list.toArray(new Integer[list.size()]);
		return (valType == int.class) ? toPrimitive(tArr) : tArr;
	}

}