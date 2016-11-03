package org.deeplearning4j.api.storage;

import org.deeplearning4j.api.storage.Persistable;
import org.deeplearning4j.api.storage.StatsStorage;

import java.util.Collection;

/**
 * StatsStorageRouter is intended to route static info, metadata and updates to a {@link StatsStorage} implementation.
 * For example, a StatsStorageRouter might serialize and send objects over a network
 *
 * @author Alex Black
 */
public interface StatsStorageRouter {


    /**
     * Method to store some additional metadata for each session. Idea: record the classes used to
     * serialize and deserialize the static info and updates (as a class name).
     * This is mainly used for debugging and validation.
     *
     * @param storageMetaData Storage metadata to store
     */
    void putStorageMetaData(StorageMetaData storageMetaData);  //TODO error handling

    void putStorageMetaData(Collection<? extends StorageMetaData> storageMetaData);

    /**
     * Static info: reported once per session, upon initialization
     *
     * @param staticInfo    Static info to store
     */
    void putStaticInfo(Persistable staticInfo);    //TODO error handling

    void putStaticInfo(Collection<? extends Persistable> staticInfo);

    /**
     * Updates: stored multiple times per session (periodically, for example)
     *
     * @param update    Update info to store
     */
    void putUpdate(Persistable update);        //TODO error handling

    void putUpdate(Collection<? extends Persistable> updates);

    //TODO async methods

}