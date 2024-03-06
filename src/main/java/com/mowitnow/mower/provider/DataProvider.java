/**
 * Interface for data providers.
 * Implementations of this interface are responsible for loading input data
 * required for the lawn mowing simulation.
 */
package com.mowitnow.mower.provider;

public interface DataProvider {
    /**
     * Loads input data for the lawn mowing simulation.
     *
     * @return InputData object containing the necessary data for the simulation.
     */
    InputData loadData();
}