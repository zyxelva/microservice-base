package com.taeyeon.zyx.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class DateDeserializerUtils implements JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		return new Date(json.getAsJsonPrimitive().getAsLong());
	}

}
