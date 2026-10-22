package com.javastudio.tutorial.mapping.mapper

import org.mapstruct.BeforeMapping
import org.mapstruct.MappingTarget
import org.mapstruct.TargetType
import java.util.IdentityHashMap

/**
 * Remembers already mapped instances so that a bidirectional graph is mapped
 * into a graph with the same shape instead of recursing endlessly.
 */
class CycleAvoidingMappingContext {

    private val knownInstances = IdentityHashMap<Any, Any>()

    @BeforeMapping
    fun <T> getMappedInstance(source: Any, @TargetType targetType: Class<T>): T? =
        knownInstances[source]?.let(targetType::cast)

    @BeforeMapping
    fun storeMappedInstance(source: Any, @MappingTarget target: Any) {
        knownInstances[source] = target
    }
}
