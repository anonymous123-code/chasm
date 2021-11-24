package org.quiltmc.chasm.api.tree;

import java.util.LinkedHashMap;

import org.quiltmc.chasm.internal.metadata.MetadataProvider;

/**
 * A {@link MapNode} implemented using a {@link LinkedHashMap}.
 */
public class LinkedHashMapNode extends LinkedHashMap<String, Node> implements MapNode {
    private MetadataProvider metadataProvider = new MetadataProvider();

    @Override
    public LinkedHashMapNode copy() {
        LinkedHashMapNode copy = new LinkedHashMapNode();
        copy.metadataProvider = metadataProvider.copy();

        for (Entry<String, Node> entry : this.entrySet()) {
            copy.put(entry.getKey(), entry.getValue().copy());
        }

        return copy;
    }

    @Override
    public MetadataProvider getMetadata() {
        return metadataProvider;
    }
}
