package com.github.puzzle.game.block;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import finalforeach.cosmicreach.blockevents.BlockEventArgs;
import finalforeach.cosmicreach.blockevents.actions.IBlockAction;
import finalforeach.cosmicreach.util.Identifier;
import org.hjson.JsonObject;

import java.util.HashMap;

public abstract class PuzzleBlockAction implements IBlockAction {

    public Identifier actionId;
    public HashMap<String, org.hjson.JsonValue> parameters = new HashMap<>();

    @Override
    public void act(BlockEventArgs args) {
        act(args);
    }

    @Override
    public void write(Json json) {}

    @Override
    public void read(Json json, JsonValue jsonData) {
        // Fuck GdxJson
        JsonObject object = JsonObject.readHjson(jsonData.toString()).asObject();
        actionId = Identifier.of(object.getString("actionId", ""));

        JsonObject params = object.get("parameters").asObject();
        for (String name : params.names()) {
            parameters.put(name, params.get(name));
        }
    }

    public HashMap<String, org.hjson.JsonValue> getParameters() {
        return parameters;
    }

    @Override
    public String getActionId() {
        return actionId.toString();
    }
}