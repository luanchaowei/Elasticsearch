/*
 * Modifications copyright (C) 2017, Baidu.com, Inc.
 * 
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.index.engine;

import org.elasticsearch.action.admin.cluster.lease.TransportGetOrChangePrimaryShardLeaseAction;
import org.elasticsearch.action.admin.indices.shard.TransportIndexShardStatsAction;
import org.elasticsearch.index.shard.IndexShard;

/**
 * Simple Engine Factory
 */
public interface EngineFactory {

    public Engine newReadWriteEngine(EngineConfig config, boolean skipTranslogRecovery);

    public Engine newReadOnlyEngine(EngineConfig config);
    
    public Engine newDLBasedEngine(EngineConfig config, boolean skipTranslogRecovery, String nodeId, 
            TransportGetOrChangePrimaryShardLeaseAction checkLeaseAction, 
            TransportIndexShardStatsAction indexShardStatsAction, 
            IndexShard indexShard);
}
