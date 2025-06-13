import request from '@/utils/request'

// 查询尿液分析数据列表
export function listUrinalysis(query) {
  return request({
    url: '/system/urinalysis/list',
    method: 'get',
    params: query
  })
}

// 查询尿液分析数据详细
export function getUrinalysis(Id) {
  return request({
    url: '/system/urinalysis/' + Id,
    method: 'get'
  })
}

// 新增尿液分析数据
export function addUrinalysis(data) {
  return request({
    url: '/system/urinalysis',
    method: 'post',
    data: data
  })
}

// 修改尿液分析数据
export function updateUrinalysis(data) {
  return request({
    url: '/system/urinalysis',
    method: 'put',
    data: data
  })
}

// 删除尿液分析数据
export function delUrinalysis(Id) {
  return request({
    url: '/system/urinalysis/' + Id,
    method: 'delete'
  })
}


export function listUrinalysisByEncounterId(encounterId) {
  return request({
    url: '/system/urinalysis/list2',
    method: 'get',
    params: { encounterId }
  })
}